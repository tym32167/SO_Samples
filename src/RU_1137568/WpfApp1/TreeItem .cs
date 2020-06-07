using System.Collections.ObjectModel;

namespace WpfApp1
{
    public class TreeItem : NotifyPropertyChanged
    {
        private TreeNodeType _nodeType;
        private int _nodeId;
        private ObservableCollection<TreeItem> _items;
        private bool _selected;
        private bool _active;

        public MainViewModel MainViewModel { get; set; }

        public int NodeId
        {
            get => _nodeId;
            set
            {
                _nodeId = value;
                OnPropertyChanged();
            }
        }
        public TreeNodeType NodeType
        {
            get => _nodeType;
            set
            {
                _nodeType = value;
                OnPropertyChanged();
            }
        }
        public ObservableCollection<TreeItem> Items // TreeViewItem.ItemsSource
        {
            get => _items;
            set
            {
                _items = value;
                OnPropertyChanged();
            }
        }
        public bool Selected // TreeViewItem.IsSelected
        {
            get => _selected;
            set
            {
                _selected = value;
                if (value)
                    Active = value;
                OnPropertyChanged();
            }
        }
        public bool Active // моя попытка выделять элемент
        {
            get => _active;
            set
            {
                if (value) MainViewModel.Deactive(NodeType);
                _active = value;
                OnPropertyChanged();
            }
        }
    }
}