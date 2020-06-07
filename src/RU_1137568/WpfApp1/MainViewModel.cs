using System.Collections.ObjectModel;


namespace WpfApp1
{
    public class MainViewModel : NotifyPropertyChanged
    {
        private ObservableCollection<TreeItem> _treeItems;
        private ObservableCollection<int> _selectedItems;

        public ObservableCollection<TreeItem> TreeItems
        {
            get => _treeItems;
            set
            {
                _treeItems = value;
                OnPropertyChanged();
            }
        }

        public ObservableCollection<int> SelectedItems // сюда хочу записать айдищшники выбранных нод
        {
            get => _selectedItems;
            set
            {
                _selectedItems = value;
                OnPropertyChanged();
            }
        }

        public void Deactive(TreeNodeType type)
        {
            if (TreeItems != null)
                foreach (var treeItem in TreeItems)
                    Deactive(treeItem, type);
        }

        private void Deactive(TreeItem node, TreeNodeType type)
        {
            if (node.Active && node.NodeType == type)
            {
                node.Active = false;
            }

            if (node.Items != null)
                foreach (var item in node.Items)
                    Deactive(item, type);
        }

        public MainViewModel()
        {
            // тестовые данные
            TreeItems = new ObservableCollection<TreeItem>
            {
                new TreeItem
                {
                    NodeId = 0,
                    NodeType = TreeNodeType.Red,
                    MainViewModel = this,
                    Items = new ObservableCollection<TreeItem>
                    {
                        new TreeItem
                        {
                            NodeId = 1,
                            NodeType = TreeNodeType.Red,
                            MainViewModel = this,
                            Items = new ObservableCollection<TreeItem>
                            {
                                new TreeItem {NodeId = 2, MainViewModel = this, NodeType = TreeNodeType.Green},
                                new TreeItem {NodeId = 3, MainViewModel = this, NodeType = TreeNodeType.Red}
                            }
                        },
                        new TreeItem {NodeId = 4, MainViewModel = this, NodeType = TreeNodeType.Red}
                    },
                    Selected = true
                },
                new TreeItem
                {
                    NodeId = 5,
                    NodeType = TreeNodeType.Blue,
                    MainViewModel = this,
                    Items = new ObservableCollection<TreeItem>
                    {
                        new TreeItem
                        {
                            NodeId = 6,
                            NodeType = TreeNodeType.Blue,
                            MainViewModel = this,
                            Items = new ObservableCollection<TreeItem>
                            {
                                new TreeItem {NodeId = 7, MainViewModel = this, NodeType = TreeNodeType.Blue}
                            }
                        },
                        new TreeItem {NodeId = 8, MainViewModel = this, NodeType = TreeNodeType.Green}
                    },
                    Selected = true
                },
                new TreeItem
                {
                    NodeId = 9,
                    NodeType = TreeNodeType.Green,
                    MainViewModel = this,
                    Selected = true
                }
            };

            SelectedItems = new ObservableCollection<int>();
        }
    }
}